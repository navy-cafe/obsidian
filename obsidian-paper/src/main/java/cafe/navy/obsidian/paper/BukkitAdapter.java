package cafe.navy.obsidian.paper;

import cafe.navy.obsidian.core.client.GameClient;
import cafe.navy.obsidian.core.player.GamePlayer;
import cafe.navy.obsidian.core.util.Position;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.Objects;
import java.util.UUID;

public final class BukkitAdapter {

    public static @NonNull Position adapt(final @NonNull Location location) {
        return new Position(location.getX(), location.getY(), location.getZ(), location.getYaw(), location.getPitch());
    }

    public static @NonNull Location toLocation(final @NonNull Position position,
                                               final @Nullable World world) {
        return new Location(world, position.x(), position.y(), position.z(), position.yaw(), position.pitch());
    }

    public static @NonNull Location toLocation(final @NonNull Position position) {
        return toLocation(position, null);
    }

    public static @NonNull Player getPlayer(final @NonNull UUID uuid)  {
        return Objects.requireNonNull(Bukkit.getPlayer(uuid));
    }

    public static @NonNull Player getPlayer(final @NonNull GamePlayer player)  {
        return getPlayer(player.uuid());
    }

    public static @NonNull Player getPlayer(final @NonNull GameClient client)  {
        return getPlayer(client.uuid());
    }

    private BukkitAdapter() {
        throw new UnsupportedOperationException("This class cannot be instantiated.");
    }


}
