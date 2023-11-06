
# cljc-io

> "The ships hung in the sky in much the same way that bricks don't." – Douglas Adams

### Overview

The <strong>cljc-io</strong> is a set of Clojure file/directory handling functions
(+ Clojure/ClojuresScript file/directory utility functions).

### deps.edn

```
{:deps {bithandshake/cljc-io {:git/url "https://github.com/bithandshake/cljc-io"
                              :sha     "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx"}}
```

### Current version

Check out the latest commit on the [release branch](https://github.com/bithandshake/cljc-io/tree/release).

### Documentation

The <strong>cljc-io</strong> functional documentation is [available here](documentation/COVER.md).

### Changelog

You can track the changes of the <strong>cljc-io</strong> library [here](CHANGES.md).

# Usage

### Index

- [How to check whether a file exists?](#how-to-check-whether-a-file-exists)

- [How to check whether a directory exists?](#how-to-check-whether-a-directory-exists)

- [How to read a file's content?](#how-to-read-a-files-content)

- [How to get the file list of a directory?](#how-to-get-the-file-list-of-a-directory)

- [How to get the file list of a directory (recursively)?](#how-to-get-the-file-list-of-a-directory-recursively)

- [How to get the subdirectory list of a directory?](#how-to-get-the-subdirectory-list-of-a-directory)

- [How to get the subdirectory list of a directory (recursively)?](#how-to-get-the-subdirectory-list-of-a-directory-recursively)

- [How to get the file and subdirectory list of a directory?](#how-to-get-the-file-and-subdirectory-list-of-a-directory)

- [How to get the file and subdirectory list of a directory (recursively)?](#how-to-get-the-file-and-subdirectory-list-of-a-directory-recursively)

- [How to check whether a directory is empty?](#how-to-check-whether-a-directory-is-empty)

- [How to create a directory?](#how-to-create-a-directory)

- [How to settle a path for a directory or file?](#how-to-settle-a-path-for-a-directory-or-file)

- [How to create an empty plain text file?](#how-to-create-an-empty-plain-text-file)

- [How to delete a file?](#how-to-delete-a-file)

- [How to duplicate a file?](#how-to-duplicate-a-file)

- [How to write into a file?](#how-to-write-into-a-file)

- [How to empty a file?](#how-to-empty-a-file)

- [How to append to the content of a file?](#how-to-append-to-the-content-of-a-file)

- [How to prepend to the content of a file?](#how-to-prepend-to-the-content-of-a-file)

- [How to empty a directory?](#how-to-empty-a-directory)

- [How to delete a directory?](#how-to-delete-a-directory)

- [How to read an EDN file?](#how-to-read-an-edn-file)

- [How to create an EDN file?](#how-to-create-an-edn-file)

- [How to write an EDN file?](#how-to-write-an-edn-file)

- [How to apply a function on an EDN file's content?](#how-to-apply-a-function-on-an-edn-files-content)

- [How to get the header from an EDN file?](#how-to-get-the-header-from-an-edn-file)

- [How to prepend to the header of an EDN file?](#how-to-prepend-to-the-header-of-an-edn-file)

### How to check whether a file exists?

The [`io.api/file-exists?`](documentation/clj/io/API.md/#file-exists)
function checks whether a file exists or not.

```
(file-exists?     "my-directory/my-file.ext")
(file-not-exists? "my-directory/my-file.ext")
```

### How to check whether a directory exists?

The [`io.api/directory-exists?`](documentation/clj/io/API.md/#directory-exists)
function checks whether a directory exists or not.

```
(directory-exists?     "my-directory/my-subdirectory")
(directory-not-exists? "my-directory/my-subdirectory")
```

### How to read a file's content?

The [`io.api/read-file`](documentation/clj/io/API.md/#read-file)
function reads the content from a file.

- By using the `{:warn? true}` setting, the function could print the warnings on the console.

```
(read-file "my-directory/my-file.ext")
(read-file "my-directory/my-file.ext" {:warn? true})
```

### How to get the file list of a directory?

The [`io.api/file-list`](documentation/clj/io/API.md/#file-list)
function reads the file list of a directory.

- By using the `{:warn? true}` setting, the function could print the warnings on the console.

```
(file-list "my-directory/my-subdirectory")
(file-list "my-directory/my-subdirectory" {:warn? true})
```

### How to get the file list of a directory (recursively)?

The [`io.api/all-file-list`](documentation/clj/io/API.md/#all-file-list)
function reads the file list of a directory (recursively).

- By using the `{:warn? true}` setting, the function could print the warnings on the console.

```
(all-file-list "my-directory/my-subdirectory")
(all-file-list "my-directory/my-subdirectory" {:warn? true})
```

### How to get the subdirectory list of a directory?

The [`io.api/subdirectory-list`](documentation/clj/io/API.md/#subdirectory-list)
function reads the subdirectory list of a directory.

- By using the `{:warn? true}` setting, the function could print the warnings on the console.

```
(subdirectory-list "my-directory/my-subdirectory")
(subdirectory-list "my-directory/my-subdirectory" {:warn? true})
```

### How to get the subdirectory list of a directory (recursively)?

The [`io.api/subdirectory-list`](documentation/clj/io/API.md/#subdirectory-list)
function reads the subdirectory list of a directory (recursively).

- By using the `{:warn? true}` setting, the function could print the warnings on the console.

```
(all-subdirectory-list "my-directory/my-subdirectory")
(all-subdirectory-list "my-directory/my-subdirectory" {:warn? true})
```

### How to get the file and subdirectory list of a directory?

The [`io.api/item-list`](documentation/clj/io/API.md/#item-list)
function reads the file and subdirectory list of a directory.

- By using the `{:warn? true}` setting, the function could print the warnings on the console.

```
(item-list "my-directory/my-subdirectory")
(item-list "my-directory/my-subdirectory" {:warn? true})
```

### How to get the file and subdirectory list of a directory (recursively)?

The [`io.api/item-list`](documentation/clj/io/API.md/#item-list)
function reads the file and subdirectory list of a directory (recursively).

- By using the `{:warn? true}` setting, the function could print the warnings on the console.

```
(all-item-list "my-directory/my-subdirectory")
(all-item-list "my-directory/my-subdirectory" {:warn? true})
```

### How to check whether a directory is empty?

The [`io.api/empty-directory?`](documentation/clj/io/API.md/#empty-directory)
function checks whether a directory is empty or not.

- By using the `{:warn? true}` setting, the function could print the warnings on the console.

```
(empty-directory? "my-directory/my-subdirectory")
(empty-directory? "my-directory/my-subdirectory" {:warn? true})
```

### How to create a directory?

The [`io.api/create-directory!`](documentation/clj/io/API.md/#create-directory)
function creates a directory on a specific path.

- By using the `{:warn? true}` setting, the function could print the warnings on the console.

```
(create-directory! "my-directory/my-subdirectory")
(create-directory! "my-directory/my-subdirectory" {:warn? true})
```

### How to settle a path for a directory or file?

The [`io.api/create-path!`](documentation/clj/io/API.md/#create-path)
function creates the (non-existing) ancestor folders of the given path.

E.g. If you pass the "my-directory/my-subdirectory/my-file.ext" path
     to this function, it creates the 'my-directory' and 'my-subdirectory'
     folders in case of they do not exist.

- By using the `{:warn? true}` setting, the function could print the warnings on the console.

```
(create-path! "my-directory/my-subdirectory/my-file.ext")
(create-path! "my-directory/my-subdirectory/my-file.ext" {:warn? true})
```

### How to create an empty plain text file?

The [`io.api/create-file!`](documentation/clj/io/API.md/#create-file)
function creates an empty plain text file on a specific path.

- By using the `{:return? true}` setting, the function will return the content of the file.
- By using the `{:warn? true}` setting, the function could print the warnings on the console.

```
(create-file! "my-directory/my-file.ext")
(create-file! "my-directory/my-file.ext" {:return? true
                                          :warn?   true})
```

### How to delete a file?

The [`io.api/delete-file!`](documentation/clj/io/API.md/#delete-file)
function deletes a file from a specific path.

- By using the `{:warn? true}` setting, the function could print the warnings on the console.

```
(delete-file! "my-directory/my-file.ext")
(delete-file! "my-directory/my-file.ext" {:warn? true})
```

### How to duplicate a file?

The [`io.api/copy-file!`](documentation/clj/io/API.md/#copy-file)
function duplicates a file to a specific path.

- By using the `{:return? true}` setting, the function will return the content of the file.
- By using the `{:warn? true}` setting, the function could print the warnings on the console.

```
(copy-file! "my-directory/my-file.ext" "my-directory/copy-file.ext")
(copy-file! "my-directory/my-file.ext" "my-directory/copy-file.ext" {:return? true
                                                                     :warn?   true})
```

### How to write into a file?

The [`io.api/write-file!`](documentation/clj/io/API.md/#write-file)
function writes the given content into a file.

- By using the `{:create? true}` setting, the function will create the file if it doesn't exist.
- By using the `{:return? true}` setting, the function will return the content of the file.
- By using the `{:warn? true}` setting, the function could print the warnings on the console.

```
(write-file! "my-directory/my-file.ext" "My content")
(write-file! "my-directory/my-file.ext" "My content" {:create? true
                                                      :return? true
                                                      :warn?   true})
```

### How to empty a file?

The [`io.api/empty-file!`](documentation/clj/io/API.md/#empty-file)
function deletes the content of a file.

- By using the `{:create? true}` setting, the function will create the file if it doesn't exist.
- By using the `{:return? true}` setting, the function will return the content of the file (after emptying it).
- By using the `{:warn? true}` setting, the function could print the warnings on the console.

```
(empty-file! "my-directory/my-file.ext")
(empty-file! "my-directory/my-file.ext" {:create? true
                                         :return? true
                                         :warn?   true})
```

### How to append to the content of a file?

The [`io.api/append-to-file!`](documentation/clj/io/API.md/#append-to-file)
function appends the given string to the content of a file.

- By using the `{:create? true}` setting, the function will create the file if it doesn't exist.
- By using the `{:max-line-count ...}` setting, the function will crop the file content if necessary.
- By using the `{:return? true}` setting, the function will return the content of the file.
- By using the `{:warn? true}` setting, the function could print the warnings on the console.

```
(append-to-file! "my-directory/my-file.ext" "My content")
(append-to-file! "my-directory/my-file.ext" "My content" {:create?        true
                                                          :max-line-count 32
                                                          :return?        true
                                                          :warn?          true})
```

### How to prepend to the content of a file?

The [`io.api/prepend-to-file!`](documentation/clj/io/API.md/#prepend-to-file)
function prepends the given string to the content of a file.

- By using the `{:create? true}` setting, the function will create the file if it doesn't exist.
- By using the `{:max-line-count ...}` setting, the function will crop the file content if necessary.
- By using the `{:return? true}` setting, the function will return the content of the file.
- By using the `{:warn? true}` setting, the function could print the warnings on the console.

```
(prepend-to-file! "my-directory/my-file.ext" "My content")
(prepend-to-file! "my-directory/my-file.ext" "My content" {:create?        true
                                                           :max-line-count 32
                                                           :return?        true
                                                           :warn?          true})
```

### How to empty a directory?

The [`io.api/empty-directory!`](documentation/clj/io/API.md/#empty-directory)
function removes the content of a directory.

- By using the `{:warn? true}` setting, the function could print the warnings on the console.

```
(empty-directory! "my-directory/my-subdirectory")
(empty-directory! "my-directory/my-subdirectory" {:warn? true})
```

### How to delete a directory?

The [`io.api/delete-directory!`](documentation/clj/io/API.md/#delete-directory)
function deletes a directory.

- By using the `{:warn? true}` setting, the function could print the warnings on the console.

```
(delete-directory! "my-directory/my-subdirectory")
(delete-directory! "my-directory/my-subdirectory" {:warn? true})
```

### How to read an EDN file?

The [`io.api/read-edn-file`](documentation/clj/io/API.md/#read-edn-file)
function reads the content of a file as an EDN structure.

- By using the `{:warn? true}` setting, the function could print the warnings on the console.

```
(read-edn-file "my-directory/my-file.edn")
(read-edn-file "my-directory/my-file.edn" {:warn? true})
```

### How to create an EDN file?

The [`io.api/create-edn-file!`](documentation/clj/io/API.md/#create-edn-file)
function creates an EDN file.

- By using the `{:return? true}` setting, the function will return the content of the file.
- By using the `{:warn? true}` setting, the function could print the warnings on the console.

```
(create-edn-file! "my-directory/my-file.edn")
(create-edn-file! "my-directory/my-file.edn" {:warn? true})
```

### How to write an EDN file?

The [`io.api/write-edn-file!`](documentation/clj/io/API.md/#write-edn-file)
function writes content into an EDN file.

- By using the `{:abc? true}` setting, the output will be ordered alphabetically.
- By using the `{:create? true}` setting, the function will create the file if it doesn't exist.
- By using the `{:return? true}` setting, the function will return the content of the file.
- By using the `{:warn? true}` setting, the function could print the warnings on the console.

```
(create-edn-file! "my-directory/my-file.edn")
(create-edn-file! "my-directory/my-file.edn" {:abc?    true
                                              :create? true
                                              :return? true
                                              :warn?   true})
```

### How to apply a function on an EDN file's content?

The [`io.api/swap-edn-file!`](documentation/clj/io/API.md/#swap-edn-file)
function applies the given function on an EDN file's content.

Unlike the other file handling functions, the `swap-edn-file!` function ...
... does not take the `options` parameter.
... always creates the file if it does not exist!
... always print a warning message when the file does not exist!

```
(swap-edn-file! "my-directory/my-file.edn" assoc-in [:items :xyz] "XYZ")
```

### How to get the header from an EDN file?

The [`io.api/read-edn-header`](documentation/clj/io/API.md/#read-edn-header)
function reads the header of an EDN file.

- By using the `{:warn? true}` setting, the function could print the warnings on the console.

```
(read-edn-header "my-directory/my-file.edn")
(read-edn-header "my-directory/my-file.edn" {:warn? true})
```

### How to prepend to the header of an EDN file?

The [`io.api/write-edn-header!`](documentation/clj/io/API.md/#write-edn-header)
function prepends the given content to the header of an EDN file.

- By using the `{:create? true}` setting, the function will create the file if it doesn't exist.
- By using the `{:return? true}` setting, the function will return the content of the file.
- By using the `{:warn? true}` setting, the function could print the warnings on the console.

```
(write-edn-header! "my-directory/my-file.edn" "First row\nSecond row")
(write-edn-header! "my-directory/my-file.edn" "First row\nSecond row"
                                              {:create? true
                                               :return? true
                                               :warn?   true})
```
