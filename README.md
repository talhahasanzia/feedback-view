# feedback-view [![Release](https://jitpack.io/v/talhahasanzia/feedback-view.svg)](https://jitpack.io/#talhahasanzia/feedback-view/v1.0)  [![GitHub issues](https://img.shields.io/github/issues/talhahasanzia/feedback-view.svg)](https://github.com/talhahasanzia/feedback-view/issues)   [![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)

Simple feedback view for android


## Release
Available Version:  [v1.0](https://github.com/talhahasanzia/feedback-view/releases/tag/v1.0) on [jitpack.io](https://jitpack.io/#talhahasanzia/feedback-view/v1.0) 


## Library Source
[Jump to library source.](https://github.com/talhahasanzia/feedback-view/tree/master/feedbackview)

## Getting Started
### Adding the library

In your project level gradle, add:
```
    maven { url "http://jitpack.io" }
```

In your app level gradle **(4.0+)**, add:
```
    implementation 'com.github.talhahasanzia:feedback-view:v1.0'
```
for gradle versions **below 4.0** use:
```
    compile 'com.github.talhahasanzia:feedback-view:v1.0'
```
## Sample usage
```
  FeedbackView feedbackView= findViewById(R.id.feedback_view);
        // set feedback question
        feedbackView.setQuery("How do you do? ");

        // set options gap (Optional)
        feedbackView.setOptionsGap(R.dimen.my_app_options_gap);

        // 25 dummy options as number
        for(int i=0; i<25; i++){
            feedbackView.addOption(String.valueOf(i));
        }

        // or add options as list
        //feedbackView.addOptions(listOptions);

        // when submit is clicked or you need to know the selected option
        String selectedOption = feedbackView.getCurrentSelection();
 ```

## License

This project is licensed under the Apache 2.0 License - see the [LICENSE.md](https://github.com/talhahasanzia/feedback-view/blob/master/LICENSE) file for details.

*Sources from Android and Android APIs are subject to the licensing terms as per Android Open Source Project (AOSP).*

