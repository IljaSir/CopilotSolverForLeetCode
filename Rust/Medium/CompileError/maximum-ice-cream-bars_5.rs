impl Solution {
    pub fn max_ice_cream(costs: Vec<i32>, coins: i32) -> i32 {
        
        let mut count = vec![0; 100001];
        for cost in costs {
            count[cost as usize] += 1;
        }
        let mut res = 0;
        for i in 1..=100000 {
            let c = count[i];
            if c == 0 {
                continue;
            }
            if coins >= i as i32 * c {
                res += c;
                coins -= i as i32 * c;
            } else {
                res += coins / i as i32;
                break;
            }
        }
        res
    }
}