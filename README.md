# Total victory

### Overview
Welcome to the Total victory - an application designed to streamline the daily tasks of legal professionals. This tool is here to simplify the lives of lawyers by helping them prioritize cases, create new ones, and efficiently manage their workload.

### Features:
- Case Prioritization: Easily prioritize cases based on dates and deadlines, ensuring that you focus on what matters most.

- Case Creation and Updates: Quickly create new cases with all the essential details, and effortlessly update existing ones as the legal landscape evolves.

- Task Management: Keep track of tasks related to each case, set deadlines, and mark them as completed to stay organized and on top of your workload.

- User-Friendly Interface: The intuitive and user-friendly interface ensures that legal professionals of all tech levels can easily navigate and use the tool.

### Getting Started

Total Victory is supported now only in Windows.

To get started with the Total victory, follow these steps:

- Clone the repository to your local machine:
  ```
  git clone https://github.com/makskostyshen/totalVictory.git
  ```
- Install [Java](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html) to your machine. It is important to do it correctly, with specifying PATH parameter in your system. Here is the [instruction](https://www.geeksforgeeks.org/how-to-set-java-path-in-windows-and-linux/)
- Create a directory for project anywhere on your PC, paste cases.csv file there
- Build the project, go to `build/libs/totalVictory-0.1-all.jar` and copy it to this directory
- Create a .bat file in this directory with commands:

```
start "" "http://localhost:8080"
java -jar "totalVictory-0.1-all.jar"
```

To start a project, simply double-click this batch file

In case of any questions, feel free to contact me makskostyshen@gmail.com
