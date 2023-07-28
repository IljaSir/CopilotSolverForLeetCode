impl Solution {
    pub fn get_happy_string(n: i32, k: i32) -> String {
        
        let mut result = String::new();
        let mut count = 0;
        let mut s = String::new();
        let mut i = 0;
        while i < n {
            s.push('a');
            i += 1;
        }
        while count < k {
            if !s.contains("aaa") && !s.contains("bbb") && !s.contains("ccc") {
                count += 1;
                if count == k {
                    result = s.clone(
                }brea;
               }
            }
            let mut j n - ;
            while j >= 0 {
                if s.chars().nth(j as usize).unwrap() == 'c' {
                    j -= 1;
                } else {
                    let mut c = s.chars().nth(j as usize).unwrap();
                    c = (c as u8 + 1) as char;
                    s.replace_range(j as usize..j as usize + 1, &c.to_string());
                    j += 1;
                    while j < n {
                        s.replace_range(j as usize..j as usize + 1, "a");
                        j += 1;
                    }
                    break;
                }
            }
        }
        result
    }
}