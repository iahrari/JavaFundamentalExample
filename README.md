# JavaFundamentals

This repository contains two projects, and you can use them side by side in IntellijIdea.

## Requirements

This project needs java 8+ and because use of .iml for defining multi modules should be opened by IntellijIdea or any IDE that supports this file extension.

## Modules
### **[utils](/utils)**
This module contains several helper classes and some useful static methods like ```CodeUtils.measureExecutionTime()``` that will measure given methods running duration.
Also, this module doesn't have any main method, so it can't run by itself.

### **[TryCatchFinallyExample](/TryCatchFinallyExample)**
This module is a small java project that read data line by line from given file.
You can run this module in IntellijIdea and add input file in 'Program arguments' or you can download jar from releases and run like this:
```bash
java -jar TryCatchFinallyExample.jar inputFile
```
If you don't specify input file in IDE or commandline you will be asked in runtime.

### **[TryWithResourcesExample](/TryWithResourcesExample)**
This module is really similar to previous one with little exceptions:
- This module uses Try with resource (as you can see in the module names :) )
- Every line of input file should be integer or otherwise the line would be ignored (with a warning in console).
- The non duplicated file that doesn't contain non integer data.
You can run this module pretty much like the previous one, with extra work of adding output file, or you'll be asked in runtime.
  ```bash
  java -jar TryWithResourcesExample.jar inputFile outputFile

```