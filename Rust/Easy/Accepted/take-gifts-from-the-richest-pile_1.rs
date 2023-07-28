impl Solution {
    pub fn pick_gifts(gifts: Vec<i32>, k: i32) -> i64 {
        
        let mut gifts = gifts;
        for _ in 0..k {
            let mut max = gifts[0];
            for i in 0..gifts.len() {
                if gifts[i] > max {
                    max = gifts[i];
                }
            }
            let mut index = 0;
            for i in 0..gifts.len() {
                if gifts[i] == max {
                    index = i;
                    break;
                }
            }
            gifts[index] = ((gifts[index] as f64).sqrt().floor() as i32) as i32;
        }
        gifts.iter().map(|&x| x as i64).sum()
    }
}