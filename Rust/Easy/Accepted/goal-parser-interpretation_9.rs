impl Solution {
    pub fn interpret(command: String) -> String {
        
        let mut res = String::new();
        let mut idx = 0;
        while idx < command.len() {
            match command[idx..].chars().next().unwrap() {
                'G' => {
                    res.push('G');
                    idx += 1;
                }
                '(' => {
                    idx += 1;
                    match command[idx..].chars().next().unwrap() {
                        'a' => {
                            res.push_str("al");
                            idx += 3;
                        }
                        _ => {
                            res.push('o');
                            idx += 1;
                        }
                    }
                }
                _ => unreachable!(),
            }
        }
        res
    }
}