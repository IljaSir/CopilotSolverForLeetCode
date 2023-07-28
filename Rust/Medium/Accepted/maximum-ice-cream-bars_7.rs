impl Solution {
    pub fn max_ice_cream(costs: Vec<i32>, coins: i32) -> i32 {
        
        let mut count = vec![0; 100001];
        for c in costs {
            count[c as usize] += 1;
        }
        let mut coins = coins;
        let mut result = 0;
        for i in 1..100001 {
            let c = count[i];
            if c == 0 {
                continue;
            }
            if coins < i as i32 {
                break;
            }
            let n = coins / i as i32;
            if n >= c {
                result += c;
                coins -= c * i as i32;
            } else {
                result += n;
                break;
            }
        }
        result
    }
}