impl Solution {
    pub fn find_min_moves(machines: Vec<i32>) -> i32 {
        
        let sum = machines.iter().sum::<i32>();
        if sum % machines.len() as i32 != 0 {
            return -1;
        }
        let avg = sum / machines.len() as i32;
        let mut ans = 0;
        let mut cur = 0;
        for i in 0..machines.len() {
            let diff = machines[i] - avg;
            cur += diff;
            ans = ans.max(diff.abs()).max(cur.abs());
        }
        ans
    }
}