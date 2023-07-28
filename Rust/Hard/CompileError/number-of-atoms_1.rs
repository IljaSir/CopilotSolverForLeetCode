impl Solution {
    pub fn count_of_atoms(formula: String) -> String {
        
        let mut stack = vec![];
        let mut i = 0;
        while i < formula.len() {
            let c = formula.chars().nth(i).unwrap();
            match c {
                '(' => {
                    stack.push(c);
                    i += 1;
                },
                ')' => {
                    let mut j = i+1;
                    let mut num = 0;
                    while j < formula.len() {
                        let c = formula.chars().nth(j).unwrap();
                        if c.is_digit(10) {
                            num = num * 10 + c.to_digit(10).unwrap() as usize;
                            j += 1;
                        } else {
                            break;
                        }
                    }
                    if num == 0 {
                        num = 1;
                    }
                    i = j;
                    let mut tmp = vec![];
                    while let Some(c) = stack.pop() {
                        if c == '(' {
                            break;
                        } else {
                            tmp.push(c);
                        }
                    }
                    for _ in 0..num {
                        for &c in tmp.iter().rev() {
                            stack.push(c);
                        }
                    }
                },
                _ => {
                    let mut j = i+1;
                    while j < formula.len() {
                        let c = formula.chars().nth(j).unwrap();
                        if c.is_lowercase() {
                            j += 1;
                        } else {
                            break;
                        }
                    }
                    let mut k = j;
                    while k < formula.len() {
                        let c = formula.chars().nth(k).unwrap();
                        if c.is_digit(10) {
                            k += 1;
                        } else {
                            break;
                        }
                    }
                    let name = formula.chars().skip(i).take(j-i).collect::<String>();
                    let num = if k > j {
                        formula.chars().skip(j).take(k-j).collect::<String>().parse::<usize>().unwrap()
                    } else {
                        1
                    };
                    for _ in 0..num {
                        stack.push(name.chars().next().unwrap());
                    }
                    i = k;
                }
            }
        }
        let mut map = std::collections::HashMap::new();
        for c in stack {
            if c.is_uppercase() {
                map.entry(c).and_modify(|e| { *e += 1; }).or_insert(1);
            } else {
                let mut k = 0;
                let
    }
}