impl Solution {
    pub fn have_conflict(event1: Vec<String>, event2: Vec<String>) -> bool {
        
        let (start1, end1) = (event1[0].parse::<i32>().unwrap(), event1[1].parse::<i32>().unwrap());
        let (start2, end2) = (event2[0].parse::<i32>().unwrap(), event2[1].parse::<i32>().unwrap());
        if start2 < end1 && end2 > start1 {
            return true;
        }
        false
    }
}