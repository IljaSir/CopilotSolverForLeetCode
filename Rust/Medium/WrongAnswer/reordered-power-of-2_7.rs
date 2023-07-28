impl Solution {
    pub fn reordered_power_of2(n: i32) -> bool {
        
        let s = n.to_string().chars().collect::<Vec<char>>();
        for i in 0..s.len() {
            let mut v = s.clone();
            v.swap(0, i);
            let n = v.iter().collect::<String>().parse::<i32>().unwrap();
            if n.count_ones() == 1 {
                return true;
            }
        }
        false
    }
}