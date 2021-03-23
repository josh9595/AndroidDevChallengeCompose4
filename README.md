# Jetpack Sunpose

<!--- Replace <OWNER> with your Github Username and <REPOSITORY> with the name of your repository. -->
<!--- You can find both of these in the url bar when you open your repository in github. -->
![Workflow result](https://github.com/josh9595/AndroidDevChallengeCompose4/workflows/Check/badge.svg)


## :scroll: Description
<!--- Describe your app in one or two sentences -->
This is my implementation of the fourth and final Jetpack Compose Android Dev Challenge, Jetpack Sunpose! 
After a busy few weeks completing each of the Dev Challenges, the best way to relax was to take my jetpack and head to a remote island for a spot of fishing 🎣
The app features a weather forecast for various locations around the world, providing the information in a clear and concise way, with an immersive UI and focus on great accessible experience.

## :bulb: Motivation and Context
<!--- Optionally point readers to interesting parts of your submission. -->
<!--- What are you especially proud of? -->

### Design
All of the background island graphics, as well as the icons I created myself, with the intention of a really engaging UI. 
With the sky/sea colours changing depending on the weather, the user can really quickly get a sense of the forecast as they scroll through.

### Accessibility
It's so important that everything we make as developers provides the best experience possible to users, regardless of any disability or impairment they may have. 
For this I wanted the screen reader experience to be as informative as possible, which I feel I achieved through building a semantic content description that is announced to the user which not only conveys all the information in the overview section of the forecast, but looks at trends during the hourly forecast to let them know if this will change.
On top of this, I used mergeDescendants to provide a single informative focusable element for the hourly forecast, as well as adding navigation buttons (as an alternative to swiping) that announce what forecast they will go to. 

### Animation
My intention for this app was to provide some subtle animations, to make the app that bit more engaging without it overtaking the content.
This I achieved by using animateColorAsState, to gradually change the background when the user changes forecast. 
It also includes the fishing line animating side to side, to help bring the design to life. 

### State
My usage of state in Jetpack Sunpose was through a pager, allowing users to swipe through the forecasts. 
This is based on the one from the Jetcast example, which I extended to support going to a specific page for the navigation buttons. 
By using Compose's state, this can remember the selected page, as well as the number of pages, to enable the draggable behaviour. 

## :camera_flash: Screenshots
<!-- You can add more screenshots here if you like -->
<img src="/results/screenshot_1.png" width="260">&emsp;<img src="/results/screenshot_2.png" width="260">&emsp;<img src="/results/screenshot_3.png" width="260">

<img src="/results/screenshot_4.png" width="260">&emsp;<img src="/results/screenshot_5.png" width="260">&emsp;<img src="/results/screenshot_6.png" width="260">

## License
```
Copyright 2020 The Android Open Source Project

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    https://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```