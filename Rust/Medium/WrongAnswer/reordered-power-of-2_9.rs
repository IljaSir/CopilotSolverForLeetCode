impl Solution {
    pub fn reordered_power_of2(n: i32) -> bool {
        
        let mut n = n.to_string();
        let mut v = n.chars().collect::<Vec<char>>();
        v.sort();
        let mut n = v.into_iter().collect::<String>();
        while n.starts_with('0') {
            n.remove(0);
        }
        let mut i = 1;
        while i < 1_000_000_000 {
            let mut v = i.to_string().chars().collect::<Vec<char>>();
            v.sort();
            let mut t = v.into_iter().collect::<String>();
            while t.starts_with('0') {
                t.remove(0);
            }
            if t == n {
                return true;
            }
            i <<= 1;
        }
        false
    }
}