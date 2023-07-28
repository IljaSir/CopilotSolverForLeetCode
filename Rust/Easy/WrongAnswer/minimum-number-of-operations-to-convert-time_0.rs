impl Solution {
    pub fn convert_time(current: String, correct: String) -> i32 {
        
        let mut current = current.split(":").map(|x| x.parse::<i32>().unwrap()).collect::<Vec<i32>>();
        let correct = correct.split(":").map(|x| x.parse::<i32>().unwrap()).collect::<Vec<i32>>();
        let mut res = 0;
        let mut time = current[0] * 60 + current[1];
        let mut target = correct[0] * 60 + correct[1];
        while time < target {
            if target - time >= 60 && time % 60 == 0 {
                time += 60;
            } else if target - time >= 15 && time % 60 % 5 == 0 {
                time += 15;
            } else if target - time >= 5 && time % 60 % 5 == 0 {
                time += 5;
            } else {
                time += 1;
            }
            res += 1;
        }
        res
    }
}