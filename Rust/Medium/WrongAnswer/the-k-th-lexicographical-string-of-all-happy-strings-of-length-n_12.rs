impl Solution {
    pub fn get_happy_string(n: i32, k: i32) -> String {
        
        let mut res = "".to_string();
        let mut arr = vec![];
        let mut i = 0;
        let mut c = 'a';
        while i < n {
            arr.push(c);
            c = (c as u8 + 1) as char;
            i += 1;
        }
        println!("{:?}", arr);
        let mut i = 0;
        while i < k {
            res = arr.iter().collect();
            if !Solution::is_happy_string(&res) {
                res = "".to_string();
            }
            i += 1;
        }
        res
    }
    
    fn is_happy_string(s: &String) -> bool {
        let mut i = 0;
        while i < s.len() - 1 {
            if s.as_bytes()[i] == s.as_bytes()[i + 1] {
                return false;
            }
            i += 1;
        }
        true
    }
}