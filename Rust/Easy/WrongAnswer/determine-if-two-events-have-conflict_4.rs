impl Solution {
    pub fn have_conflict(event1: Vec<String>, event2: Vec<String>) -> bool {
        
        let time1 = event1[0].split(":").collect::<Vec<&str>>();
        let time2 = event1[1].split(":").collect::<Vec<&str>>();
        let time3 = event2[0].split(":").collect::<Vec<&str>>();
        let time4 = event2[1].split(":").collect::<Vec<&str>>();
        let start1 = time1[0].parse::<i32>().unwrap() * 60 + time1[1].parse::<i32>().unwrap();
        let end1 = time2[0].parse::<i32>().unwrap() * 60 + time2[1].parse::<i32>().unwrap();
        let start2 = time3[0].parse::<i32>().unwrap() * 60 + time3[1].parse::<i32>().unwrap();
        let end2 = time4[0].parse::<i32>().unwrap() * 60 + time4[1].parse::<i32>().unwrap();
        if start1 < start2 {
            end1 > start2
        } else {
            end2 > start1
        }
    }
}