# FRC-Robot

This is the incubating software framework for ILITE's 2019 season.

## Contributing

Here's how to get your code into the main robot repository:

### If you've just joined the team:
1. Make an account on [GitHub](https://github.com/).
2. Ask one of the robot programming leads to add your account to the iliterobotics robot programming team.

### If it's the first time you've contributed to this repo:
1. Fork this repo
  1. Log onto github and navigate to the repo
  2. Click the "Fork" button in the upper right corner of the screen.
2. Clone your forked repo.
  * `git clone https://github.com/<your_name>/robot-code.git`, where <your_name> is your github username.

### Any time you want to make a change:
1. Create and checkout a new branch.
  * `git checkout -b <your_branch_name>`, where <your_branch_name> is a descriptive name for your branch. For example `fix-shooter-wheel`, `two-ball-auto`, or `climbing`. Use dashes in the branch name, not underscores.
2. Make whatever code changes you want/need/ to make. Be sure to write tests for your changes!
3. Commit your work locally.
  * Try to make your commits as atomic (small) as possible. For example, moving functions around should be different from adding features, and changes to one subsystem should be in a different commit than changes to another subsystem.
  * Follow [these](http://tbaggery.com/2008/04/19/a-note-about-git-commit-messages.html) conventions for commit messages. Or else.
  * If your change is anything more than a few lines or small fixes, don't skip the extended description. If you are always using `git commit` with the `-m` option, stop doing that.
4. Push to your forked repo.
  * `git push origin <your_branch_name>`.
5. Submit a pull request.
  1. Log into github.
  2. Go to the page for your forked repo.
  3. Select the branch that you just pushed from the "Branch" dropdown menu.
  4. Click "New Pull Request".
  5. Review the changes that you made.
  6. If you are happy with your changes, click "Create Pull Request".
6. Wait
  * People must review (and approve of) your changes before they are merged.
    * Specifically, the rules are that one of the following two conditions must be true for it to get merged:
      1. 1 mentor and 1 other person have approved
      2. 2 experienced students and one other person have approved
  * If there are any concerns about your pull request, fix them. Depending on how severe the concerns are, the pull request may be merged without it, but everyone will be happier if you fix your code. To update your PR, just push to the branch on your forked repo.
  * Don't dismiss someone's review when you make changes - instead, ask them to re-review it.
7. Merge your changes into master
  * If there are no conflicts, push the "Squash and merge" button, write a good commit message, and merge the changes.
  * If there are conflicts, fix them locally on your branch, push them, wait for Jenkins to pass, and then squash and merge.
8. ???
9. Profit

## Helpful Tips

### Other remotes

You can add "remotes" to github that refer to other people's robot code repos. This allows you to, for example, take a look at someone else's code to look over it, you would be able to `git checkout wesley/branch-that-breaks-everything` to see it. To add a remote, just do `git remote add <name_of_person> https://github.com/<username>/robot-code`. Once you've done this, you can use `git fetch <name_of_person>` to get updated code from other people's repos!

### Setting up a new computer

