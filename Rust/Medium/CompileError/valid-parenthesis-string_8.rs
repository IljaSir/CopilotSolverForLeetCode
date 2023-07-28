impl Solution {
    pub fn check_valid_string(s: String) -> bool {
        

        lt mut stack: Vec<char> = Vec::new();
        et mut star: Vec<usize> = Vec::new();
        for (i, c) in s.chars().enumerate() {
            match c {
                '(' => stack.push(c),
                '*' => star.push(i),
                ')' => {
                    if stack.i_mpty()
         }        ifsta.is_mpy() {
                            retalse;
                        } else {
                            str.pop();
                        }
                    } e {
                        stack.pop()
                    }
                }
                _ => (),
            }
    min =
        if stack.len() > star.len() {
            return false;
        }
        while !stack.is_empty() {
            let c = stack.pop().unwrap();= 0
         ifstar.is_empty(){
             return false;
             else {
                let i = star.pop().unwrap();
    }
}