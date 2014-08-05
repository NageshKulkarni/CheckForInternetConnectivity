# CheckForInternetConnectivity

###What this project do :: 

    This Project shows demo to check whether internet connectivity is available or not available

![Screen Navigation](https://github.com/devrath/CheckForInternetConnectivity/blob/master/snapshot.png)


---

## Project Observations

* onlick of the button Asynchronoous background task is started 

* In the asynchronous task check whether data packets are enabled and also whether is it possible to recieve a reply ffrom the provided web service

* If both conditions are true display message `Connected to internet` otherwise display message as `Not connected to internet`

* Add these lines in the manifest

  `<uses-permission android:name="android.permission.INTERNET" />`

  `<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />`


---

## App Specifications

* Minimum Sdk = 14
* Compiled with = 19
* Tested in android emulator

### Download from DropBox
[![Download from DropBox](https://dt8kf6553cww8.cloudfront.net/static/images/icons/blue_dropbox_glyph-vflJ8-C5d.png)](https://www.dropbox.com/s/zdvkv31hhe3m9av/CheckForInternetConnectivity.rar)


License
=======


    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.


Who Made This?
--------------
<a href="http://stackoverflow.com/users/1083093/devrath">
<img src="http://stackoverflow.com/users/flair/1083093.png" width="208" height="58" alt="profile for Devrath at Stack Overflow, Q&amp;A for professional and enthusiast programmers" title="profile for Devrath at Stack Overflow, Q&amp;A for professional and enthusiast programmers">
</a>
