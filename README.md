# 根据名称批量删除指定文件或文件夹

当我们从网上下载资料时，可能会遇到这样的情况↓，在下载的资料中包含很多广告文件，这些广告文件在每一个子目录中都存在，对于有强迫症的人来说，很想把它们全都删掉，但是如果子目录很多，手动删除就会很麻烦，所以编写了一个程序，实现自动删除指定文件。

![](https://psvm001.oss-cn-beijing.aliyuncs.com/boke/blogImage/70bfb3a5-9ed2-4ef6-a38f-234b0b352a9d.png)

运行程序，按照提示输入相关内容。

是否包含子目录：如果选择是，则会删除子目录中的指定文件；如果选择否，则只会删除当前目录下的指定文件；

删除文件or文件夹：如果选择删除文件，则只会删除相匹配的文件；如果选择删除文件夹，则只会删除相匹配的文件夹；如果选择删除文件和文件夹，则会忽略文件的拓展名，删除相匹配的文件和文件名；

若文件夹不为空是否删除：如果选择是，当匹配的文件夹不为空时，则会把文件夹及里面的内容（无论是否匹配）删除；反之，则不会删除。

![](https://psvm001.oss-cn-beijing.aliyuncs.com/boke/blogImage/f4f6313d-304a-4619-a658-9c4c6f183fb0.png)

当输入完参数后，程序会按照输入的参数执行，同时控制台打印删除的文件的目录及删除的文件数量。

![](https://psvm001.oss-cn-beijing.aliyuncs.com/boke/blogImage/867d9a08-8e2b-4b36-976b-3b654b1e069d.png)
