# TinyCompiler
用Java实现一个微型编译器

> 目标是,将LISP语句编译成C语句:
```text
               LISP                      C
               
2 + 2          (add 2 2)                 add(2, 2)
4 - 2          (subtract 4 2)            subtract(4, 2)
2 + (4 - 2)    (add 2 (subtract 4 2))    add(2, subtract(4, 2))
```
## 第一步: Tokenizer
- 输入:
```text
(add 2 (subtract 4 2))
```

- 输出:
```text
[
    (paren,(), 
    (name,add), 
    (number,2), 
    (paren,(), 
    (name,subtract), 
    (number,4), 
    (number,2), 
    (paren,)), 
    (paren,))
]
```

## 第二步: Parser

## 第三步: traverser遍历AST

## 第四步: transformer转换AST

## 第五步: ecodegen&compiler



参考:
- https://github.com/jamiebuilds/the-super-tiny-compiler