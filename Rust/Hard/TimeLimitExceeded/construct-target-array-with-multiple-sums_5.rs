impl Solution {
    pub fn is_possible(target: Vec<i32>) -> bool {
        
        let mut v = target;
        let mut sum = v.iter().sum::<i32>();
        let n = v.len();
        while v.iter().any(|x| *x != 1) {
            let mut max = 0;
            let mut index = 0;
            for i in 0..n {
                if v[i] > max {
                    max = v[i];
                    index = i;
                }
            }
            let prev = v[index];
            v[index] = sum - v[index];
            sum -= prev - v[index];
            if v[index] < 1 || sum < v[index] {
                return false;
            }
        }
        true
    }
}