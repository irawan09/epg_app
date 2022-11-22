


# Welcome to Proexe Android recruitment task

Your task is to implement some parts of the app according to supplied designs and refactor messy
code already present in the project.

## Design

You can preview the
design [here](https://www.figma.com/file/wn2XsBsDYSqZTppTDwkkSZ/Zadanie-rekrutacyjne-v2?node-id=0%3A1)
.

Log in to Figma using your account or create one (it is free) to inspect the design and be able to
check precise design requirements (Inspect Mode). Colors and icons are included in the Android
Studio project. If something is missing, add it manually by extracting resources from the Figma
project (Export in Inspect Mode).

## Task

There are 4 parts of this task described below. Try to do as much as you can. Feel free to add  
needed files, classes libraries, patterns that are required to provide quality etc. The source  
Code contains the bare minimum for the application. The rest is up to you. We highly encourage you
to use Jetpack Compose, but it is not a requirement. Feel free to implement UI using the technology
you prefer.

### 1. [List of programs](https://www.figma.com/file/wn2XsBsDYSqZTppTDwkkSZ/Zadanie-rekrutacyjne-v2?node-id=0%3A1)

You should implement the main view with the list (especially list of programmes and horizontal bar
with timestamps). Try to make it as close to the design as possible.

### 2. Download list of programmes and integrate them with timestamps row

Programs for your application are currently stored [here](https://jsonkeeper.com/b/GG8C). Download
them for your application with help of your favorite HTTP Client and display as a content of the
list you built in the first task.
<br>For timestamps row you can use the already provided local repository of
timestamps: `TimeRepository`. </br>
Note: There are already some models created for you. Feel free to use them if you want or write your
own models.

### 3. Test the code you have written

Write simple tests for parts of the app which in your opinion are worth testing in "real-life"
application project.

### 4. Move favourite channels to top

Order of programmes provided from your data source represents some kind of rank. Programmes with
higher rank are displayed below programmes with lower rank.  
Programmes added to favorites are not ranked by rank, but by the order of addition.

Implement functionality where long pressing on a program not added to favorites will add it to
favorites and move it to the top of the list.  
Long clicking on favored programme should move it back to list of programmes and place it according
to the rank rule described above.

Note 1: Write tests to ensure correctness.  
Note 2: Check out this GIF which presents a simplified [example](media/list.gif) of what you have to
implement.

## Time

You have 24 hours to complete the task.

## Git

You should create additional git branches and commits as needed.

## Solution

Your solution will be the topic of discussion during your technical interview. Focus not only on
accordance to design and app functionality, but overall code structure and app architecture.

## Sending your solution

Please send your solution as a .zip file with the git inside as attachment with the thread we    
started sending a task in the first place.