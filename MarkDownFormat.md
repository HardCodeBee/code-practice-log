# MARKDOWN Format Learning(USE IT IN EDIT CONDITION)

## Document Skeleton
| Purpose         | Syntax (example)                        |
| --------------- | --------------------------------------- |
| H1 (once)       | `# Project Title`                       |
| H2 / H3…        | `## Installation`   `### Step 1`        |
| Paragraph break | *Blank line*                            |
| Hard line break | Two spaces at line end `␠␠↵`          |
| Thematic break  | `---` or `***` or `___` on its own line |


## Inline Styling
| Effect            | Markdown                    |
| ----------------- | --------------------------- |
| *Italic*          | `*text*` or `_text_`        |
| **Bold**          | `**text**` or `__text__`    |
| ***Bold italic*** | `***text***`                |
| ~~Strikethrough~~ | `~~text~~`                  |
| `Code span`       | `` `code` ``                |
| Escape literal    | `\*asterisk\*` → *asterisk* |


## List & Task Lists

- Bullet A
  - Sub-item A-1
* Same level can start with *
+ Or with +

1. Ordered one
2. **Numbers may repeat**; HTML renderer fixes order
   1. Nested

- [x] Finished task
- [ ] Open task


## Links & Images
[Inline link](https://example.com)

[Reference link][gh]
[gh]: https://github.com  "optional title"

<https://bare.url>          <!-- autolink -->

![Alt text](img/logo.png)

      
