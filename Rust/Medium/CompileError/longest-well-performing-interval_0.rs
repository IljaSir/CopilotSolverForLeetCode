impl Solution {
    pub fn longest_wpi(hours: Vec<i32>) -> i32 {
        
        let mut sum = 0;
        let mut res = 0;
        let mut map = HashMap::new();
        for (i, &h) in hours.iter().enumerate() {
            sum += if h > 8 { 1 } else { -1 };
            if sum > 0 {
                res = i + 1;
            } else {
                map.entry(sum).or_insert(i);
                if let Some(&j) = map.get(&(sum - 1)) {
                    res = res.max(i - j);
                }
            }
        }
        res as i32
    }
}