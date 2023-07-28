impl Solution {
    pub fn alert_names(key_name: Vec<String>, key_time: Vec<String>) -> Vec<String> {
        
        let mut hm = std::collections::HashMap::new();
        for (name, time) in key_name.iter().zip(key_time) {
            let time = time.split(":").map(|x| x.parse::<i32>().unwrap()).collect::<Vec<_>>();
            let time = time[0] * 60 + time[1];
            let entry = hm.entry(name).or_insert_with(Vec::new);
            entry.push(time);
        }
        let mut ret = Vec::new();
        for (name, times) in hm {
            let mut times = times;
            times.sort();
            for i in 0..times.len() - 2 {
                if times[i + 2] - times[i] <= 60 {
                    ret.push(name.clone());
                    break;
                }
            }
        }
        ret.sort();
        ret.dedup();
        ret
    }
}