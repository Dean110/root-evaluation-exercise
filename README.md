# Root Evaluation Exercise
## Problem Statement
From [Dan Manges Gist](https://gist.github.com/dan-manges/1e1854d0704cb9132b74):

Let's write some code to track driving history for people.

The code will process an input file. You can either choose to accept the input via stdin (e.g. if you're using Ruby `cat input.txt | ruby yourcode.rb`), or as a file name given on the command line (e.g. `ruby yourcode.rb input.txt`). You can use any programming language that you want. Please choose a language that allows you to best demonstrate your programming ability.

Each line in the input file will start with a command. There are two possible commands.

The first command is Driver, which will register a new Driver in the app. Example:

`Driver Dan`

The second command is Trip, which will record a trip attributed to a driver. The line will be space delimited with the following fields: the command (Trip), driver name, start time, stop time, miles driven. Times will be given in the format of hours:minutes. We'll use a 24-hour clock and will assume that drivers never drive past midnight (the start time will always be before the end time). Example:

`Trip Dan 07:15 07:45 17.3`

Discard any trips that average a speed of less than 5 mph or greater than 100 mph.

Generate a report containing each driver with total miles driven and average speed. Sort the output by most miles driven to least. Round miles and miles per hour to the nearest integer.

Example input:

```
Driver Dan
Driver Lauren
Driver Kumi
Trip Dan 07:15 07:45 17.3
Trip Dan 06:12 06:32 21.8
Trip Lauren 12:01 13:16 42.0
```

Expected output:

```
Lauren: 42 miles @ 34 mph
Dan: 39 miles @ 47 mph
Kumi: 0 miles
```

## My Approach
### Tech Used
I am going to be using a simple Java command line application. 
I had originally considered using Spring Boot to boot strap Spring application. 
This would allow me to use Spring's dependency injection and Spring Data to leverage a relational database to manage relationships between Drivers and Trips.
After doing some object modeling, I believe I can create an application that doesn't depend on a framework.
### Object Modeling
- DataFileReader - takes the data file name and reads the content into a `String`.
- DataProcesser - takes a `String` and parses it looking for the 'Driver' and 'Trip' commands and generating `Driver` and `Trip` objects.
- Driver - contains the data about the driver name and their trips
- Trip - contains the start and endtime of a trip and the miles driven.
- DriverRoster - contains a map of drivers and some methods to access and add data to the drivers.
- ReportGenerator - Reads a driver roster object and returns a report of the drivers mileage and average speed in the proper order.
