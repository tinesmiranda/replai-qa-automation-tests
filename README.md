# replai-qa-automation-tests

*Instructions*

This is the file that contains the instructions to download the project. The other file "Notes" has the description of the project.
In "main" branch you can find the .txt "README" and "Notes" files, and in "master" branch there's the project

Before you proceed, make sure that you have Git, Maven and JDK installed on your computer
I used IntelliJ IDEA for this project

To extract project to computer, use Git Bash.
1. Search for "Git Bash"
2. Write a command with the location you want to put the project, or write "cd" and drag the location folder to Git Bash. Example:

$ cd '/c/Users/Teresa/replai-qa-automation-tests'


3. Go to repository page - https://github.com/tinesmiranda/replai-qa-automation-tests
5. Click on "Code", and then copy the link below "Clone" option
6. Use git clone and chose "master" branch to download the project:

$ git clone -b master https://github.com/tinesmiranda/replai-qa-automation-tests.git


Now you can open the project on your IDE. Open the folder "replai-qa-automation-tests".
To install packages, use IDE command line:

mvn clean package install

To run tests, use IDE command line:

mvn test
OR
mvn -P ExecuteTestSuite test
