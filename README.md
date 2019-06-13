# Table Creator

Your task is to produce `CREATE TABLE` SQL commands from classes containing JPA annotations.

## Supported Annotations

* `@Entity` - specifies that the class represents entity (table)
    * `name` - (optional) table name
* `@Id` - specifies field as a `PRIMARY KEY`
* `@GeneratedValue` - specifies that the field values should autoincrement (append `AUTO_INCREMENT` at the end of the column definition)
* `@Column` - provides additional column information
    * `name` - (optional) column name
    * `length` - (optional) column length (use for VARCHAR types)
    * `nullable` - (optional) specifies if the field can be null
* `@Transient` - field is ignored
* `@Enumerated` - field is an enum
    * `value` - (optional) specifies how to encode an enum (int or String)

## Supported Java Types

* `long` maps to `BIGINT`
* `String` maps to `VARCHAR`
* `int` maps to `INTEGER`
* `EnumType.ORDINAL` to `INTEGER`
* `EnumType.STRING` to `VARCHAR(25)`

## How to submit

Call me when the tests pass.

GL & HF :)
