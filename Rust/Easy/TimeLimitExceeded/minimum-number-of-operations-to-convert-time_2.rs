impl Solution {
    pub fn convert_time(current: String, correct: String) -> i32 {
        
        let mut current = current.split(":").map(|s| s.parse::<i32>().unwrap()).collect::<Vec<_>>();
        let mut correct = correct.split(":").map(|s| s.parse::<i32>().unwrap()).collect::<Vec<_>>();
        let mut ans = 0;
        while current != correct {
            if current[1] < correct[1] {
                ans += 1;
                current[1] += 1;
            }
            if current[1] == correct[1] && current[0] < correct[0] {
                ans += 1;
                current[1] += 1;
            }
            if current[1] == 60 {
                current[1] = 0;
                current[0] += 1;
            }
            if current[0] == 24 {
                current[0] = 0;
            }
        }
        ans
    }
}