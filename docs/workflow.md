# Workflow & developing process of this project
Here you can find all needed information about development process of this project.

## Process
1. You need to take an issue to work. Available issues are located in **"Open"** column. When you chose the desirable issue:
   - Move it to **"In progress"** column
   - Assign yourself
   - Create branch from this issue on issue menu
2. When you work on a issue, do it in its branch only and commit only in this branch
3. When you complete the issue:
   - Create a pull request to this issue
   - Move it to **"Tech review & test"** column
   - Assign [responsible person](https://github.com/makskostyshen)
   - Very soon responsible person will check this issue
4. If it has no problems:
   - Issue will be moved to **"Ready to merge"** column
   - In this stage you merge to master and move issue to **"Done"** column
5. If issue has some code quality problems:
   - It will be moved to **"Feedback"** column
   - Corresponding messages will appear in the pull request of issue branch
   - You make fixes to comments, move task to **"Tech review & test"** column and assign responsible person
   - Feel free to ask additional questions
   - If you disagree with comment, explain it, move to **"Tech review & test"** and assign responsible person
6. If issue has some code working problems:
   - It will be moved to **"Feedback"** column
   - Problems will be described in comment
   - You make fixes to comments, move task to **"Tech review & test"** column and assign responsible person
   - Feel free to ask additional questions
   - If you disagree with comment, explain it, move to **"Tech review & test"** and assign responsible person



## Issues
Every issue corresponds to its task. It has name and description. For example:

**vict-69: [Backup] - add backup file (1h)**
- **vict-69** - identifier of task
- **[Backup]** - name of group of tasks
- **add backup file** - description
- **(1h)** - estimate

Some issues have bigger priority than others. Usually it is clear from context.
If not - there is description of which issue is needed to be done before the current.

When working with task on every day basis, you need to track your time:

**worked 1h**:
- **read doc of framework x**
- **create controller**
- **...**

Contact me in case of any suggestions or improvements