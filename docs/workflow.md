# Workflow & developing process of this project
Here you can find all needed information about development process of this project.

## Process of working on task
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

## Priorities

In case of multiple tasks on the same board, there is a priority of each stage:
1. Ready to merge
2. Feedback
3. In progress
4. Open

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

## Branches

Branch should have the name of its issue:

- Issue: **vict-69: [Backup] - add backup file (1h)**
- Branch: **vict-69**

Work, related to specific issue needs to be done only in its branch

## Commits

Every commit should be explained by its name. Name should be specific.
Name convention on example:

**vict-69: Create repository methods**

- **vict-69:** - name of task, every commit should start from name of branch
- **Create repository methods** - what was done

Contact me in case of any suggestions or improvements