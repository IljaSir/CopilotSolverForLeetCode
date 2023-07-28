impl Solution {
    pub fn convert_time(current: String, correct: String) -> i32 {
        
        let mut current = current.split(':').map(|s| s.parse::<i32>().unwrap()).collect::<Vec<_>>();
        let correct = correct.split(':').map(|s| s.parse::<i32>().unwrap()).collect::<Vec<_>>();
        let mut res = 0;
        if correct[1] < current[1] {
            res += 1;
            current[0] += 1;
        }
        if correct[0] < current[0] {
            res += 1;
            current[0] -= 24;
        }
        res += (correct[1] - current[1]) / 5;
        res += (correct[0] - current[0]) * 12;
        res
    }
}