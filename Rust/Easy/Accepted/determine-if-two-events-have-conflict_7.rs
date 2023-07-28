impl Solution {
    pub fn have_conflict(event1: Vec<String>, event2: Vec<String>) -> bool {
        
        let mut e1: Vec<i32> = Vec::new();
        let mut e2: Vec<i32> = Vec::new();
        for i in event1 {
            let time: Vec<i32> = i.split(':').map(|x| x.parse::<i32>().unwrap()).collect();
            e1.push(time[0] * 60 + time[1]);
        }
        for i in event2 {
            let time: Vec<i32> = i.split(':').map(|x| x.parse::<i32>().unwrap()).collect();
            e2.push(time[0] * 60 + time[1]);
        }
        if e1[0] <= e2[0] && e1[1] >= e2[0] {
            return true;
        } else if e1[0] <= e2[1] && e1[1] >= e2[1] {
            return true;
        } else if e1[0] >= e2[0] && e1[1] <= e2[1] {
            return true;
        } else if e1[0] <= e2[0] && e1[1] >= e2[1] {
            return true;
        }
        false
    }
}