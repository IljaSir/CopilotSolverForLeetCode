impl Solution {
    pub fn to_hex(num: i32) -> String {
        
        if num == 0 {
            return "0".to_string();
        }
        let mut num = num;
        let mut res = String::new();
        let mut map = vec!['0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'];
        let mut mask = 15;
        while num != 0 {
            res.push(map[(num & mask) as usize]);
            num = num >> 4;
        }
        res.chars().rev().collect()
    }
}