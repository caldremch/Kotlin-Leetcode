### vsocde code runner config

in settings.json

```groovy
  "code-runner.runInTerminal": true,
  "code-runner.executorMapByFileExtension": {
    ".kt": "cd $dir && kotlinc $fileName -include-runtime -d $workspaceRoot/build/kotlincOutput/$fileNameWithoutExt.jar && java -jar $workspaceRoot/build/kotlincOutput/$fileNameWithoutExt.jar"
  },
```


