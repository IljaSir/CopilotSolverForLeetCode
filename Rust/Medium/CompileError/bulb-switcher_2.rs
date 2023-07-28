impl Solution {
    pub fn bulb_switch(n: i32) -> i32 {
        

        let mut bulbs = vec![false; n as usize];
        for i in 1..=n {
            for j in (i-1..n as usize).step_by(i as usize) {
                bulbs[j] = !bulbs[j];
            }
        }
        bulbs.iter().filter(|&&b| b).count() as i32
    }
}