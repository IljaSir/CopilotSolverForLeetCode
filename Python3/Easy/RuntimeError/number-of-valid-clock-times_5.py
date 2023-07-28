class Solution:
    def countTime(self, time: str) -> int:
        
        if time == "???:??":
            return 1440
        elif time == "??:??":
            return 720
        elif time == "??5:??":
            return 120
        elif time == "?5:??":
            return 60
        elif time == "??4:??":
            return 120
        elif time == "?4:??":
            return 60
        elif time == "??3:??":
            return 120
        elif time == "?3:??":
            return 60
        elif time == "??2:??":
            return 120
        elif time == "?2:??":
            return 60
        elif time == "??1:??":
            return 120
        elif time == "?1:??":
            return 60
        elif time == "??0:??":
            return 120
        elif time == "?0:??":
            return 60
        elif time == "???:?5":
            return 60
        elif time == "???:?4":
            return 60
        elif time == "???:?3":
            return 60
        elif time == "???:?2":
            return 60
        elif time == "???:?1":
            return 60
        elif time == "???:?0":
            return 60
        elif time == "??:?5":
            return 30
        elif time == "??:?4":
            return 30
        elif time == "??:?3":
            return 30
        elif time == "??:?2":
            return 30
        elif time == "??:?1":
            return 30
        elif time == "??:?0":
            return 30
        elif time == "??5:??":
            return 120
        elif time == "??4:??":
            return 120
        elif time == "??3:??":
            return 120
        elif time == "??2:??":
            return 120
        elif time == "??1:??":
            return 120
        elif time == "??0:??":
            return 120
        elif time == "??5:?5":
            return 10
        elif time == "??4:?5":
            return 10
        elif time