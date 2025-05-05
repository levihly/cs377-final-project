# ReleaseFinder

## Why did we make this app?

This app was made to faciliate the looking up of whether or not a music release
is part of the first set to come out, i.e., not a repress/reissue. For example,
you want to see if a vinyl record you found in a record store came out when the
album first came out in say, 1977, or if it was a later copy released in say, 2008.

## How is this done?

This app is made with Kotlin, and makes use of the Discogs API, provided by Discogs,
a music discography tracker and marketplace. While an account was needed to get an
authentication key to use the API, it was all able to be done for free. This app
makes use of the API through Retrofit, and stores data via Room, both being important
but easily accessible Android dependencies. Another dependency utilized is KSP, or
Kotlin Symbol Processing, which is used to help Kotlin process Java annotations. For
loading a release's thumbnail/cover art, we made use of the Coil library. Also
necessary were the Navigation and ViewModel libraries, which allowed easy movement
between fragments and the implementation of ViewModels, respectively.

## How does it work?

The user inputs a catalog number(essentially a music release's serial number) into the
home page searchbar, and clicks the submit button. If the catalog number is valid and
found in the Discogs system, the app will select the first release in the response. This
is due to the fact that for a widely-distributed release, multiple releases will typically
share the same catalog number. Most of these releases are released within the same one to
three year span however, so generally selecting the first release will still be a good
reflection as to if it's an original release or not. After this, the app will then navigate
to a details page for that release, stating its name, catalog number, year, and then a block
of text saying if it's an original release or not.

## Architectural Style:

As mentioned above, we made use of ViewModels. This was to facilitate the use of MVVM, or
Model-View-ViewModel architecture, our software architecture of choice for this project.
We mainly chose it because it worked so well for each of our recipe lookup apps, and we
figured that since the function of the ReleaseFinder app would be so similar, it would be
a good choice.

## Instructions:

1. Run and open the ReleaseFinder app on your Android device or emulator.

2. On the home page, enter the release you're looking at's catalog number into the search
bar with the text "Type a catalog number" in it.

3. Once you've typed in a catalog number and are ready to see more about that release, click
the submit button.

4. If you entered a valid, correct catalog number, you will be taken to a release details
page, where you will be told if it's likely an original release copy or not.

5. If you would like to search again, click the "Back to Home" button at the bottom of the
release details page to be navigated back to the home page.
