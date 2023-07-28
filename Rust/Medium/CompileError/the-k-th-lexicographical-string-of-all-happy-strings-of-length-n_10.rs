impl Solution {
    pub fn get_happy_string(n: i32, k: i32) -> String {
        
        let mut res = String::new();
        let mut count = 0;
        let mut visited = vec![vec![vec![false; 3]; 3]; 11];
        let mut stack = Vec::new();
        stack.push(('a' as i32, 0));
        stack.push(('b' as i32, 0));
        stack.push(('c' as i32, 0));
        while !stack.is_empty() {
            let (c, i) = stack.pop().unwrap();
            if i == n as usize {
                count += 1;
                if count == k {
                    return res;
                }
                continue;
            }
            for j in 0..3 {
                if (c as u8 - 'a' as u8) as usize == j {
                    continue;
                }
                if visited[i][c as usize - 'a' as usize][j] {
                    continue;
                }
                visited[i][c as usize - 'a' as usize][j] = true;
                res.push(c as u8 as char);
                stack.push((j as u8 + 'a' as u8, i + 1));
            }
        }
        "".to_string()
        let mut res = "".to_string();
        let mut i = 1;
        let mut s = vec!['a','b','c'];
        while i <= k {
            let mut j = 0;
            while j < n {
                if j == 0 {
                    res.push(s[0]);
                } else if j == 1 {
                    if res.chars().last().unwrap() == 'a' {
                        res.push(s[1]);
                    } else {
                        res.push(s[0]);
                    }
                } else {
                    if res.chars().last().unwrap() == 'a' {
                        if res.chars().rev().nth(1).unwrap() == 'b' {
                            res.push(s[2]);
                        } else {
                            res.push(s[1]);
                        }
                    } else if res.chars().last().unwrap() == 'b' {
                        if res.chars().rev().nth(1).unwrap() == 'a' {
                            res.push(s[2]);
                        } else {
                            res.push(s[0]);
                        }
                    } else {
                        if res.chars().rev().nth(1).unwrap() == 'a' {
                            res.push(s[1]);
                        } else {
                            res.push(s[0]);
                        }
                    }
                }
                j += 1;
            }
            i += 1;
        }
        res
    }
}