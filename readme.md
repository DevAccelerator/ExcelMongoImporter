[![Build Status](https://travis-ci.org/bcostea/ExcelMongoImporter.svg?branch=master)](https://travis-ci.org/bcostea/ExcelMongoImporter)

Import xls and xlsx files directly to MongoDB collections.

## Goals
1. Import UTF-8 content from XLS and XLSX files directly to MongoDB collections
2. Bulk import files, creating collections if they don't exist, appending if they exist
3. Ability to add defaults/extra values from an external file
