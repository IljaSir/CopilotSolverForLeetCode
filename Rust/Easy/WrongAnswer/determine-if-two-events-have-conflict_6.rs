impl Solution {
    pub fn have_conflict(event1: Vec<String>, event2: Vec<String>) -> bool {
        
        let mut v1 = event1[0].split(":").collect::<Vec<&str>>();
        let mut v2 = event2[0].split(":").collect::<Vec<&str>>();
        let a = v1[0].parse::<i32>().unwrap() * 60 + v1[1].parse::<i32>().unwrap();
        let b = v2[0].parse::<i32>().unwrap() * 60 + v2[1].parse::<i32>().unwrap();
        v1 = event1[1].split(":").collect::<Vec<&str>>();
        v2 = event2[1].split(":").collect::<Vec<&str>>();
        let c = v1[0].parse::<i32>().unwrap() * 60 + v1[1].parse::<i32>().unwrap();
        let d = v2[0].parse::<i32>().unwrap() * 60 + v2[1].parse::<i32>().unwrap();
        if a < d && b > c {
            return true;
        }
        false
    }
}