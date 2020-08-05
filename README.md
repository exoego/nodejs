# scala-js-nodejs

Scala.js type facades for Node.js v10, v12 and v14.

## Support matrix

|            |            ScalaJS 0.6.28+            |           ScalaJS 1.x           |
| ---------- | :-----------------------------------: | :-----------------------------: |
| Scala 2.13 | :heavy_check_mark: (v0.12.0 is final) | :heavy_check_mark: from v0.10.0 |
| Scala 2.12 | :heavy_check_mark: (v0.12.0 is final) | :heavy_check_mark: from v0.10.0 |
| Scala 2.11 |                  N/A                  |               N/A               |
| Scala 2.10 |                  N/A                  |               N/A               |

-   :heavy_check_mark: Supported
-   :construction: Not supported but planned

## Supported Modules

Almost all Node.js modules, except [experimental modules](https://github.com/exoego/scala-js-nodejs/issues?q=is%3Aissue+is%3Aopen+label%3Amissing), are supported.
Feel free to open issue/send pull request if you find missing module.

## How to use

Add below line to your SBT project.

```sbt
// For Node.js v10 LTS (Will be dropped on 2021-4-30)
libraryDependencies += "net.exoego" %%% "scala-js-nodejs-v10" % "0.12.0"
// For Node.js v12 LTS
libraryDependencies += "net.exoego" %%% "scala-js-nodejs-v12" % "0.12.0"
// For Node.js v14 LTS
libraryDependencies += "net.exoego" %%% "scala-js-nodejs-v14" % "0.12.0"
```

## Example of code

### Callback-style JavaScript (prior to async/await)

```javascript
var output1 = null;
var output2 = null;
var output3 = null;

fs.mkdirp("/a/test/dir", function (err1) {
    Assert.ifError(err1);

    fs.writeFile("/a/test/dir/file.txt", "Hello World", function (err2) {
        Assert.ifError(err2);

        fs.readFile("/a/test/dir/file.txt", function (err3, data) {
            Assert.ifError(err3);
            output1 = data; // ~> Buffer("Hello World")

            fs.unlink("/a/test/dir/file.txt", function (err4) {
                Assert.ifError(err4);

                fs.readdir("/a/test", function (err5, dir) {
                    Assert.ifError(err5);
                    output2 = dir; // ~> ["dir"]

                    fs.stat("/a/test/dir", function (err6, stats) {
                        Assert.ifError(err6);
                        output3 = stats.isDirectory(); // ~> true

                        fs.rmdir("/a/test/dir", function (err7) {
                            Assert.ifError(err7);
                            fs.mkdirp("C:\\use\\windows\\style\\paths", function (err8) {
                                Assert.ifError(err8);
                                
                                console.log("output1 =", output1.toString(), output1);
                                console.log("output2 =", output2);
                                console.log("output3 =", output3)
                            })
                        })
                    })
                })
            })
        })
    })
});
```

Now consider the equivalent logic in Scala.js using its much more elegant `for` comprehension:

### Scala.js

```scala
import io.scalajs.nodejs.console
import io.scalajs.nodejs.Fs._
  
for {
  _ <- Fs.mkdirpFuture("/a/test/dir")
  _ <- Fs.writeFileFuture("/a/test/dir/file.txt", "Hello World")
  output1 <- Fs.readFileFuture("/a/test/dir/file.txt") // ~> Buffer("Hello World")
  _ <- Fs.unlinkFuture("/a/test/dir/file.txt")
  output2 <- Fs.readdirFuture("/a/test") // ~> ["dir"]
  output3 <- Fs.statFuture("/a/test/dir").map(_.isDirectory()) // ~> true
  _ <- Fs.rmdirFuture("/a/test/dir")
  _ <- Fs.mkdirpFuture("C:\\use\\windows\\style\\paths")
} {
  console.log("output1 =", output1.toString(), output1)
  console.log("output2 =", output2)
  console.log("output3 =", output3)
}
```

## Note

This facade leverages [`@Factory` marcro](https://github.com/exoego/scalajs-types-util#factory-macro) to create highly-optimized factory method without boilerplate.
