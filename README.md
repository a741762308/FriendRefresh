#:running: FriendRefresh:running:
仿微信朋友圈刷新
#动态截图
![](https://github.com/a741762308/FriendRefresh/blob/master/sreenshot/GIF.gif)
#使用方法
## build.gradle添加
```java
dependencies {
compile 'com.jsqix.dq.friend:friendMoment:1.0.0'
}
```
##java代码
```java
  mListAdapter = new ListAdapter();
        mWrapListView = (FriendRefreshView) findViewById(R.id.wrapview);
        mWrapListView.setAdapter(mListAdapter);
        mWrapListView.setLoadEnable(true);//加载更多
//        mWrapListView.setTopbackground();//修改背景
//        mWrapListView.setTopName();//修改用户名
//        mWrapListView.setTopNameColor();//修改字体颜色
//        mWrapListView.setTopHead();//修改头像
        mWrapListView.setOnRefreshListener(this);
        mWrapListView.setOnItemClickListener(this);
```
##Layout
```java
  <com.jsqix.dq.friend.FriendRefreshView
        android:id="@+id/wrapview"
        android:layout_width="match_parent"
        android:layout_height="match_parent" />
```
#License

    Copyright 2015 a741762308

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

