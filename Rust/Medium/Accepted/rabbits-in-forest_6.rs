impl Solution {
    pub fn num_rabbits(answers: Vec<i32>) -> i32 {
        
        let mut count = [0; 1000];
        for &ans in &answers {
            count[ans as usize] += 1;
        }
        let mut res = 0;
        for (i, &v) in count.iter().enumerate() {
            if v > 0 {
                res += (v + i as i32) / (i as i32 + 1) * (i as i32 + 1);
            }
        }
        res
    }
}