impl Solution {
    pub fn find_min_moves(machines: Vec<i32>) -> i32 {
        
        let total = machines.iter().sum::<i32>();
        if total % machines.len() as i32 != 0 {
            return -1;
        }
        let avg = total / machines.len() as i32;
        let mut ans = 0;
        let mut sum = 0;
        for num in machines {
            let diff = num - avg;
            sum += diff;
            ans = ans.max(sum.abs()).max(diff);
        }
        ans
    }
}