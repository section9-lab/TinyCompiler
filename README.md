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
- 输入:
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

- 输出:
```
ASTProgramNode{
    type='Program',
    body=[
        ASTCallNode{
            name='add',
            type='CallExpression',
            params=[
                ASTNumberNode{
                    type='NumberLiteral',
                    value='2'
                },
                ASTCallNode{
                    name='subtract',
                    type='CallExpression',
                    params=[
                        ASTNumberNode{
                            type='NumberLiteral',
                            value='4'
                        },
                        ASTNumberNode{
                            type='NumberLiteral',
                            value='2'
                        }
                    ]
                }
            ]
        }
    ]
}
```

## 第三步: transformer转换AST
- 输入:
```text
input:ASTProgramNode{
    type='Program', 
    body=[
        ASTCallNode{
            name='add', 
            type='CallExpression', 
            params=[
                ASTNumberNode{
                    type='NumberLiteral', 
                    value='2'
                }, 
                ASTCallNode{
                    name='subtract', 
                    type='CallExpression', 
                    params=[
                        ASTNumberNode{
                            type='NumberLiteral', 
                            value='4'
                        }, 
                        ASTNumberNode{
                            type='NumberLiteral', 
                            value='2'
                        }
                    ]
                }
            ]
        }
    ]
}

```
 - 输出:
```text
output:ASTProgramNode{
    type='Program', 
    body=[
        ASTExpr2Node{
            expression=ASTExprNode{
                name='null', 
                callee=ASTCalleeNode{
                    name='add'
                }, 
                arguments=[
                    ASTNumberNode{
                        type='NumberLiteral', 
                        value='2'
                    }, 
                    ASTExprNode{
                        name='null', 
                        callee=ASTCalleeNode{
                            name='subtract'
                        },
                        arguments=[
                            ASTNumberNode{
                                type='NumberLiteral', 
                                value='4'
                            }, 
                            ASTNumberNode{
                                type='NumberLiteral', 
                                value='2'
                            }
                        ]
                    }
                ]
            }
        }
    ]
}
```
## 第四步: genCode
- 输出:
```text
add(2,subtract(4,2));
```


参考:
- https://github.com/jamiebuilds/the-super-tiny-compiler