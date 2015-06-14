Toasteroid Library
================================

Out of the box library for displaying Android toasts with steroids, based on the cool library [Android-AppMsg](https://github.com/johnkil/Android-AppMsg)

Just one line and you'll have a nice an fancy Toast!

Sample
------

A sample application is available inside of the library

![screenshot][1]
![screenshot][2]
![screenshot][3]

Compatibility
-------------

This library is compatible from API 4 (Android 1.6).

Usage
-----

To display a Toasteroid:

* From the basic:

``` java
Toasteroid.show(Activity activity, String message, STYLES style);
```

* to more complex:

``` java
Toasteroid.show(Activity activity, String message, STYLES style, long duration, int gravity, Animation inAnimation, Animation outAnimation);
```

Gradle
------

Toasteroid uses the awesome tool [Jitpack] (https://jitpack.io/)

Add the repository to your general build.gradle:

``` xml
repositories {
	    maven {
	        url "https://jitpack.io"
	    }
	}
```

And then add the library in your specific project build.gradle:

``` xml
    compile 'com.github.marcohc:toasteroid:1.0.2'
```

Contribution
------------

Please fork the repository and contribute back using pull requests.

Contributors are recommended to follow the Android [Code Style Guidelines](http://source.android.com/source/code-style.html).

Any contributions, large or small, major features, bug fixes, additional language translations, unit/integration tests are welcomed and appreciated but will be thoroughly reviewed and discussed.

Developed By
------------

* Marco Hernaiz Cao - <marco.hernaiz.cao@gmail.com>

Credits
-------

 * [johnkil][4] - Author of [Android-Android-AppMsg][5] in which this library is based.


License
-------

    Copyright 2015 Marco Hernaiz Cao

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

[1]: http://i61.tinypic.com/281redu.jpg
[2]: http://i58.tinypic.com/r2tdeo.png
[3]: http://i60.tinypic.com/1zbutmc.png
[4]: https://github.com/johnkil
[5]: https://github.com/johnkil/Android-AppMsg
