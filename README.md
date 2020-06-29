# workshop-vue

## Requirements
- Java 8+ or Node 12+

## Instructions
The following command will start a Webpack development server that
watches the files for changes and automatically reloads the server.

The webpage will be available at <http://localhost:3000/#/>.

```bash
# If you have Node installed.
$ npm run serve
```

```bash
# Otherwise you can use Gradle.
$ ./gradlew npm_run_serve
```

JavaScript files are located in `src/main/js`. The compiled bundle
is located in `src/main/resources/static` which is served by Armeria.
