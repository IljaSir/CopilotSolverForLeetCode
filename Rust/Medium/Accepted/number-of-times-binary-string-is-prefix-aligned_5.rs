impl Solution {
    pub fn num_times_all_blue(flips: Vec<i32>) -> i32 {
        
        let mut lights = vec![false; flips.len()];
        let mut max = 0;
        let mut res = 0;
        for i in flips {
            lights[(i - 1) as usize] = true;
            if i as usize > max {
                max = i as usize;
            }
            if lights[0..max].iter().all(|&x| x) {
                res += 1;
            }
        }
        res
    }
}