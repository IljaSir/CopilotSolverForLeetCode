impl Solution {
    pub fn max_ice_cream(costs: Vec<i32>, coins: i32) -> i32 {
        
        let mut counts = vec![0; 100001];
        for cost in costs {
            counts[cost as usize] += 1;
        }
        let mut count = 0;
        for i in 0..counts.len() {
            if coins >= i as i32 {
                let c = coins / i as i32;
                if c < counts[i] {
                    count += c;
                    break;
                } else {
                    count += counts[i];
                    coins -= counts[i] * i as i32;
                }
            }
        }
        count
    }
}